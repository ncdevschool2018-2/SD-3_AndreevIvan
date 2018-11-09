import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Profile} from 'src/app/modules/users/profile';
import {Service} from '../modules/serviceCatalogue/service';


@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private http: HttpClient) {

  }

  getBillingAccounts(): Observable<Profile[]> {
    return this.http.get<Profile[]>('/api/user');
  }

  getSubVariants(): Observable<any> {
    return this.http.get('assets/subscribitionVariants.json')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }
  getServices(): Observable<Service[]> {
    return this.http.get<Service[]>('/api/services');
  }
  getUserInfo(): Observable<any> {
    return this.http.get('assets/myProfile.json')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  getMyServices(): Observable<any> {
    return this.http.get('assets/myServices.json')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }
  /*getUsers(): Observable<any> {
    return this.http.get('assets/users.json')
      .pipe(
        catchError(error => {
            alert('error');
          return Observable.throw(error);
        })
      );
  }*/

  deleteServiceFromMyServices(id: string): Observable<any> {
    return this.http.get('assets/myServices.json', {params: {id}})
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  deleteUser(id: string): Observable<any> {
    return this.http.get('assets/users.json', {params: {id}})
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }
}
