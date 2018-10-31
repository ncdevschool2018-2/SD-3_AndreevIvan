import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ButtonsModule} from 'ngx-bootstrap';
import {FormsModule} from '@angular/forms';
import { BsDropdownModule } from 'ngx-bootstrap';
import { ModalModule } from 'ngx-bootstrap';
import {LogInComponent} from './logIn.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [
    LogInComponent
  ],
  declarations: [
    LogInComponent
  ],
  providers: []
})
export class LogInModule {

}
