import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ClientesComponent } from './clientes.component';



@NgModule({
  declarations: [
    ClientesComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ClientesComponent
  ]
})
export class ClientesModule { }
