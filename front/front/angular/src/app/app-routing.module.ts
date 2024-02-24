import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './components/inicio/inicio.component';
import { NuevoAgremiadoComponent } from './components/nuevo-agremiado/nuevo-agremiado.component';
import { AgregarConsultorioComponent } from './components/agregar-consultorio/agregar-consultorio.component';
import { MenuPrincipalComponent } from './components/menu-principal/menu-principal.component';

const routes: Routes = [
  {path: '', component: MenuPrincipalComponent},
  {path: 'inicio', component: InicioComponent},
  {path: 'nuevoAgremiado', component: NuevoAgremiadoComponent},
  {path: 'agregarConsultorio', component: AgregarConsultorioComponent}, 
  {path: '**', redirectTo:''},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
