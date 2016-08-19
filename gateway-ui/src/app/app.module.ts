import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RequestOptions, HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {AppComponent}  from './app.component';
import {MyBaseRequestOptions} from "./baseRequest";
import {KeycloakService} from "./keycloak";
import {AuthGuard} from "./common/guards/auth-guard";
import {routing} from "./app.routing";
import {HomeComponent} from "./components/home/home.component";
import {ConfigureBusinessPartnerComponent} from "./components/configure-business-partner/configure-business-partner.component"
import {BusinessPartnerService} from "./common/services/business-partner.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    ConfigureBusinessPartnerComponent
  ],
  bootstrap: [AppComponent],
  providers: [
    {provide: RequestOptions, useClass: MyBaseRequestOptions},
    KeycloakService,
    BusinessPartnerService,
    AuthGuard
  ]
})
export class AppModule {
}
