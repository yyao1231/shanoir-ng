import { Component } from '@angular/core';

import { KeycloakService } from './shared/keycloak/keycloak.service';

@Component({
    selector: 'shanoir-ng-app',
    templateUrl: 'app.component.html'
})

export class AppComponent {

    constructor() {
    }

    isAuthenticated(): boolean {
        return KeycloakService.auth.loggedIn;
    }

}