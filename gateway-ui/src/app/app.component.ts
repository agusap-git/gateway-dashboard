import { Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'my-app',
    template: `
          <h1>My First Angular 2 App</h1>
          <router-outlet></router-outlet>
     `
})
export class AppComponent { }
