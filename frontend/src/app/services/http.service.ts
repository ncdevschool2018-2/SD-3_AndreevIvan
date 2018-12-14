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
    console.log(newService);
    return this.http.post<Service>('/api/services', newService);
  }
  createUserService(newUserService: UserService): Observable<UserService> {
    console.log(newUserService);
    return this.http.post<UserService>('/api/userService', newUserService);
  }
  updateUserService(status: number, userId: number, serviceId: number): Observable<void> {
    let params = new HttpParams().set('status', status.toString());
    params = params.set('userId', userId.toString());
    params = params.set('serviceId', serviceId.toString());
    return this.http.get<void>('/api/userService/updateStatus/', {params: params});
  }
  getServices(): Observable<Service[]> {
    console.log('start parsing services...');
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

  getHavingServices(userId: number): Observable<Service[]> {
    if (userId < 0) {
      return;
    }
    return this.http.get<Service[]>('/api/services/getServicesFromUserByUserId/' + userId);
  }

  updateUser(editedProfile: Profile): Observable<Profile> {
    if (editedProfile.id < 0) {
      console.log('invalid user!!!');
      return;
    }
    console.log('start updateUser()');
    console.log(editedProfile);
    return this.http.post<Profile>('/api/user/updateUser', editedProfile);

  }

  deleteService(id: string): Observable<void> {
    return this.http.delete<void>('api/services/' + id);
  }
  deleteUserService(id: string): Observable<void> {
    return this.http.delete<void>('api/userService/deleteuserservice/' + id);
  }
}
