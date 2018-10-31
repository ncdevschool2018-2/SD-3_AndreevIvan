import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ButtonsModule} from 'ngx-bootstrap';
import {FormsModule} from '@angular/forms';
import { BsDropdownModule } from 'ngx-bootstrap';
import { ModalModule } from 'ngx-bootstrap';
import {ServiceCatalogueComponent} from './serviceCatalogue.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [
    ServiceCatalogueComponent
  ],
  declarations: [
    ServiceCatalogueComponent
  ],
  providers: []
})
export class ServiceCatalogueModule {

}
