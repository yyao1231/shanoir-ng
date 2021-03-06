import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';

import { ExtensionRequestInfo } from '../extension-request/extension-request-info.model';
import { User } from './user.model';
import * as AppUtils from '../../utils/app.utils';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }

    confirmAccountRequest(id: number, user: User): Observable<User> {
        return this.http.put<User>(AppUtils.BACKEND_API_USER_URL + '/' + id + AppUtils.BACKEND_API_USER_CONFIRM_ACCOUNT_REQUEST_URL,
            JSON.stringify(user))
            .map(response => response);
    }

    create(user: User): Observable<User> {
        return this.http.post<User>(AppUtils.BACKEND_API_USER_URL, JSON.stringify(user))
            .map(res => res);
    }

    delete(id: number): Promise<void> {
        return this.http.delete<void>(AppUtils.BACKEND_API_USER_URL + '/' + id)
            .toPromise()
            .catch((error) => {
                console.error('Error delete user', error);
                return Promise.reject(error.message || error);
            });
    }

    denyAccountRequest(id: number): Promise<void> {
        return this.http.delete<void>(AppUtils.BACKEND_API_USER_URL + '/' + id + AppUtils.BACKEND_API_USER_DENY_ACCOUNT_REQUEST_URL)
            .toPromise()
            .catch((error) => {
                console.error('Error deny user account request', error);
                return Promise.reject(error.message || error);
            });
    }

    getUser(id: number): Promise<User> {
        return this.http.get<User>(AppUtils.BACKEND_API_USER_URL + '/' + id)
            .toPromise()
            .then(response => response)
            .catch((error) => {
                console.error('Error while getting user', error);
                return Promise.reject(error.message || error);
            });
    }

    getUsers(): Promise<User[]> {
        return this.http.get<User[]>(AppUtils.BACKEND_API_USER_URL)
            .toPromise();
    }

    requestAccount(user: User): Observable<User> {
        return this.http.post<User>(AppUtils.BACKEND_API_USER_ACCOUNT_REQUEST_URL, JSON.stringify(user));
    }

    requestExtension(extensionRequestInfo: ExtensionRequestInfo): Promise<void | ErrorObservable> {
        return this.http.put<void>(AppUtils.BACKEND_API_USER_EXTENSION_REQUEST_URL, JSON.stringify(extensionRequestInfo))
            .toPromise();
    }

    update(id: number, user: User): Observable<User> {
        return this.http.put<User>(AppUtils.BACKEND_API_USER_URL + '/' + id, JSON.stringify(user))
            .map(response => response);
    }

}