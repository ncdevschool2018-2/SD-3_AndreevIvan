import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable()
export class HttpService {
  constructor(private http: HttpClient) {

  }

  getUsers(): Observable<any> {
    return this.http.get('assets/users.json')
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
