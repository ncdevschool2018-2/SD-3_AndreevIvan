import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersModule } from './modules/users/users.module';
import {HttpService} from './services/http.service';
import {HttpClientModule} from '@angular/common/http';
import {UsersComponent} from './modules/users/users.component';
import {MyServicesComponent} from './modules/myServices/myServices.component';
import {RouterModule} from '@angular/router';
import {ButtonsModule} from 'ngx-bootstrap';
import { AlertModule } from 'ngx-bootstrap';
import {MyServicesModule} from './modules/myServices/myServices.module';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {LogInModule} from './modules/logIn/logIn.module';
import {LogInComponent} from './modules/logIn/logIn.component';
import {SignUpComponent} from './modules/signUp/signUp.component';
import {SignUpModule} from './modules/signUp/signUp.module';
import {MyProfileComponent} from './modules/myProfile/myProfile.component';
import {MyProfileModule} from './modules/myProfile/myProfile.module';
import {ServiceCatalogueComponent} from './modules/serviceCatalogue/serviceCatalogue.component';
import {ServiceCatalogueModule} from './modules/serviceCatalogue/serviceCatalogue.module';



const pathes = [
  {path: 'serviceCatalogue', component: ServiceCatalogueComponent},
  {path: 'myProfile', component: MyProfileComponent},
  {path: 'signUp', component: SignUpComponent},
  {path: 'logIn', component: LogInComponent},
  {path: 'users', component: UsersComponent},
  {path: 'myServices', component: MyServicesComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    ServiceCatalogueModule,
    MyProfileModule,
    SignUpModule,
    LogInModule,
    NgbModule,
    BrowserModule,
    HttpClientModule,
    UsersModule,
    MyServicesModule,
    RouterModule.forRoot(pathes),
    ButtonsModule.forRoot(),
    AlertModule.forRoot()
  ],
  providers: [
    HttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
