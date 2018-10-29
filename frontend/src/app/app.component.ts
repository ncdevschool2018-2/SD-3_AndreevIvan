import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpService} from './services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  @ViewChild('usersTemplate') readonly usersTemplate;

  users: any = [];

  notificationMessage: string;
  isShowNotification: boolean;

  constructor(private http: HttpService) {
    this.showNotification('Succes');
  }

  showNotification(message) {
    this.notificationMessage = message;
    this.isShowNotification = true;

    setTimeout(() => this.isShowNotification = false, 3000);
  }

  ngOnInit() {
    this.http.getUsers()
      .subscribe(
        users => this.users = users,
        () => alert('error')
      );
  }

  // users = [{name: 'Eduard'}, {name: 'Aleksandr'}];
}
