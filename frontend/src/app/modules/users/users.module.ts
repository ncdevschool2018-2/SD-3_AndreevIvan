import {NgModule} from '@angular/core';
import {UsersComponent} from './users.component';
import {CommonModule} from '@angular/common';
import {FilterPipe} from './filter.pipe';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BsDropdownModule } from 'ngx-bootstrap';
import { ModalModule } from 'ngx-bootstrap';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { WavesModule, InputsModule, ButtonsModule } from 'angular-bootstrap-md';
import {
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatRippleModule
} from '@angular/material';


@NgModule({
  imports: [
    WavesModule,
    InputsModule,
    ButtonsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatProgressSpinnerModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [
    UsersComponent,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule
  ],
  declarations: [
    FilterPipe,
    UsersComponent
  ],
  providers: []
})
export class UsersModule {

}
