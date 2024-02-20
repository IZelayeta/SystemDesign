import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './components/inicio/inicio.component';
import { NuevoAgremiadoComponent } from './components/nuevo-agremiado/nuevo-agremiado.component';

const routes: Routes = [
  {path: '', component: InicioComponent},
  {path: 'nuevoAgremiado', component: NuevoAgremiadoComponent}, 
  {path: '**', redirectTo:''},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
