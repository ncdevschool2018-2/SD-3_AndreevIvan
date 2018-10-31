import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ButtonsModule} from 'ngx-bootstrap';
import {FormsModule} from '@angular/forms';
import {MyProfileComponent} from './myProfile.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot()
  ],
  exports: [
    MyProfileComponent
  ],
  declarations: [
    MyProfileComponent
  ],
  providers: []
})
export class MyProfileModule {

}
