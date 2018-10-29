import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersModule } from './modules/users/users.module';
import {HttpService} from './services/http.service';
import {HttpClientModule} from '@angular/common/http';
import {UsersComponent} from './modules/users/users.component';
import {RouterModule} from '@angular/router';
import {ButtonsModule} from 'ngx-bootstrap';
import { AlertModule } from 'ngx-bootstrap';

const pathes = [
  {path: 'users', component: UsersComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    UsersModule,
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
