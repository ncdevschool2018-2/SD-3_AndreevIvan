import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ButtonsModule} from 'ngx-bootstrap';
import {FormsModule} from '@angular/forms';
import { BsDropdownModule } from 'ngx-bootstrap';
import { ModalModule } from 'ngx-bootstrap';
import {SignUpComponent} from './signUp.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [
    SignUpComponent
  ],
  declarations: [
    SignUpComponent
  ],
  providers: []
})
export class SignUpModule {

}
