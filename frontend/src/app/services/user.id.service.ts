import {BehaviorSubject, Observable} from 'rxjs';
import {Injectable} from '@angular/core';

const INIT_DATA = [];


@Injectable()
export class UserIDService {
  private loggedUserID = new BehaviorSubject(INIT_DATA);
  data: Observable<any> = this.loggedUserID.asObservable();

  constructor() {
    this.loggedUserID.next([-1]);
  }

  getID() {
    return this.loggedUserID.getValue();
  }

  setID(id: number) {
    console.log(id);
    this.loggedUserID.next([id]);
  }
}
