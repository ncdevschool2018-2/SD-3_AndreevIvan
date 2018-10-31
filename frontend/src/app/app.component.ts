import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpService} from './services/http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent /*implements OnInit */{
  /*@ViewChild('usersTemplate') readonly usersTemplate;
  @ViewChild('myServicesTemplate') readonly myServicesTemplate;*/

  users: any = [];

  homePageActive = false;
  myServicesPageActive = false;
  cataloguePageActive = false;
  myProfilePageActive = false;


  notificationMessage: string;
  isShowNotification: boolean;

  isCollapsed = true;

  toggleMenu() {
    this.isCollapsed = !this.isCollapsed;
  }

  /*constructor(private http: HttpService) {
    this.showNotification('Success');
  }

  showNotification(message) {
    this.notificationMessage = message;
    this.isShowNotification = true;

    setTimeout(() => this.isShowNotification = false, 3000);
  }*/


  isHomePageActive() {
    return this.homePageActive;
  }
  isMyServicesPageActive() {
    return this.myServicesPageActive;
  }
  isCataloguePageActive() {
    return this.cataloguePageActive;
  }
  isMyProfilePageActive() {
    return this.myProfilePageActive;
  }
  setHomePageActive() {
    this.homePageActive = true;
    this.myServicesPageActive = false;
    this.cataloguePageActive = false;
    this.myProfilePageActive = false;
  }
  setMyServicesPageActive() {
    this.homePageActive = false;
    this.myServicesPageActive = true;
    this.cataloguePageActive = false;
    this.myProfilePageActive = false;
  }
  setCataloguePageActive() {
    this.homePageActive = false;
    this.myServicesPageActive = false;
    this.cataloguePageActive = true;
    this.myProfilePageActive = false;
  }
  setMyProfilePageActive() {
    this.homePageActive = false;
    this.myServicesPageActive = false;
    this.cataloguePageActive = false;
    this.myProfilePageActive = true;
  }
  /*ngOnInit() {
    this.http.getUsers()
      .subscribe(
        myServices => this.myServices = myServices,
        () => alert('error')
      );
  }*/

  // myServices = [{name: 'Eduard'}, {name: 'Aleksandr'}];
}
