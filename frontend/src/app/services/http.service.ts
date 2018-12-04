import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Profile} from 'src/app/modules/users/profile';
import {Service} from '../modules/serviceCatalogue/service';
import {UserService} from '../modules/myServices/userService';
import {SignUpProfile} from '../modules/signUp/signUp.component';
import {stringify} from 'querystring';


@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private http: HttpClient) {

  }

  getUsers(): Observable<Profile[]> {
    return this.http.get<Profile[]>('/api/user');
  }
  createUser(newUser: SignUpProfile): Observable<Profile> {
    return this.http.post<Profile>('/api/user', newUser);
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
  createService(newService: Service): Observable<Service> {
    console.log('26');
    console.log(newService);
    return this.http.post<Service>('/api/services', newService);
  }
  getServices(): Observable<Service[]> {
    return this.http.get<Service[]>('/api/services');
  }
  getUserById(id: number): Observable<Profile> {
    const params = new HttpParams().set('id', id.toString());
    return this.http.get<Profile>('api/user/getbyid/', {params: params});
  }
  getUserByLoginAndPassword(login: string, password: string): Observable<Profile> {
    console.log('start getUser()');
    let params = new HttpParams().set('login', login);
    params = params.set('password', password);
    console.log('parsed login: ' + login);
    console.log('parsed password: ' + password);
    return this.http.get<Profile>('/api/user/getbydata', {params: params});
  }

  getUserServices(id: number): Observable<UserService[]> {
    if (id < 0) {
      return;
    }
    return this.http.get<UserService[]>('/api/userService/' + id);
  }

  setUserTokens(editedProfile: Profile): Observable<Profile> {
    if (editedProfile.id < 0) {
      console.log('user is not logged in!!!');
      return;
    }
    console.log('start setUserTokens()');
    console.log(editedProfile);
    return this.http.post<Profile>('/api/user/setTokens', editedProfile);

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
