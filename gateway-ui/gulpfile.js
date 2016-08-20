/**
 * Created by aaltamir on 8/11/16.
 */
"use strict";

const gulp = require("gulp");
const del = require("del");
const tsc = require("gulp-typescript");
const sourcemaps = require('gulp-sourcemaps');
const tsProject = tsc.createProject("src/tsconfig.json");
const tslint = require('gulp-tslint');
const karma = require('karma').Server;

var bases = {
  dist: 'dist/',
  vendor: 'dist/vendor/'
};

/**
 * Remove dist directory.
 */
gulp.task('clean', function (cb) {
  return del([bases.dist], cb);
});

/**
 * Lint all custom TypeScript files.
 */
gulp.task('tslint', function () {
  return gulp.src("src/**/*.ts")
    .pipe(tslint())
    .pipe(tslint.report('prose'));
});

/**
 * Compile TypeScript sources and create sourcemaps in dist directory.
 */
gulp.task("compile", ["tslint"], function () {
  var tsResult = gulp.src("src/**/*.ts")
    .pipe(sourcemaps.init())
    .pipe(tsc(tsProject));
  return tsResult.js
  // .pipe(sourcemaps.write("."))
    .pipe(sourcemaps.write("./", {
      sourceRoot: __dirname + '/src'
    }))
    .pipe(gulp.dest(bases.dist));
});

/**
 * Copy all resources that are not TypeScript files into dist directory.
 */
gulp.task("resources", function () {
  return gulp.src(["src/**/*", "!**/*.ts"])
    .pipe(gulp.dest(bases.dist));
});

/**
 * Copy all required libraries into dist directory.
 */
gulp.task("libs", function () {

  //@angular libs
  gulp.src(['@angular/**/*.+(js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "@angular"));

  //@core-js libs
  gulp.src(['core-js/**/*.+(js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "core-js"));

  //@core-js libs
  gulp.src(['core-js/**/*.+(js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "core-js"));

  //primeng
  gulp.src(['primeng/**/*.+(js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "primeng"));

  //primeng
  gulp.src(['primeui/**/*'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "primeui"));

  //systemjs
  gulp.src(['systemjs/dist/system-polyfills.js',
      'systemjs/dist/system.src.js'],
    {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "systemjs/dist"));

  //reflect-metadata
  gulp.src(['reflect-metadata/**/*.+(ts|js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "reflect-metadata"));

  //zone.js
  gulp.src(['zone.js/dist/**/*.+(js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "zone.js/dist"));

  //reflect-metadata
  gulp.src(['rxjs/**/*.+(js|js.map)'], {cwd: 'node_modules'})
    .pipe(gulp.dest(bases.vendor + "rxjs"));
});

/**
 * Watch for changes in TypeScript, HTML and CSS files.
 */
gulp.task('watch', function () {
  gulp.watch(["src/**/*.ts"], ['compile']).on('change', function (e) {
    console.log('TypeScript file ' + e.path + ' has been changed. Compiling.');
  });
  gulp.watch(["src/**/*.html", "src/**/*.css", "src/config/*.json"], ['resources']).on('change', function (e) {
    console.log('Resource file ' + e.path + ' has been changed. Updating.');
  });
});

/**
 * Build the project.
 */
gulp.task("build", ['compile', 'resources', 'libs'], function () {
  console.log("Building Gateway-Dashboard Skeleton ...");
});

/**
 * Testing
 */
gulp.task('test', function (done) {
  new karma({
    configFile: __dirname + '/karma.conf.js',
  }).start();
});
