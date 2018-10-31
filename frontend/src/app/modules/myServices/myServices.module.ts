import {NgModule} from '@angular/core';
import {MyServicesComponent} from './myServices.component';
import {CommonModule} from '@angular/common';
import {FilterPipe} from './filter.pipe';
import {ButtonsModule} from 'ngx-bootstrap';
import {FormsModule} from '@angular/forms';
import { BsDropdownModule } from 'ngx-bootstrap';
import { ModalModule } from 'ngx-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [
    MyServicesComponent
  ],
  declarations: [
    FilterPipe,
    MyServicesComponent
  ],
  providers: []
})
export class MyServicesModule {

}
