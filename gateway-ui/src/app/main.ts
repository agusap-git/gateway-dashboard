import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app.module';
import {KeycloakService} from './keycloak';

KeycloakService.init().then(
  o => {
    platformBrowserDynamic().bootstrapModule(AppModule);
  },
  x => {
    window.location.reload();
  }
).catch(reason => console.log(reason));

