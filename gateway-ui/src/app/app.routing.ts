import { Routes, RouterModule } from '@angular/router';
import {AuthGuard} from "./common/guards/auth-guard";
import {HomeComponent} from "./components/home/home.component";
import {ConfigureBusinessPartnerComponent} from "./components/configure-business-partner/configure-business-partner.component";


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'business-partner', component: ConfigureBusinessPartnerComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

export const routing = RouterModule.forRoot(appRoutes);


/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
