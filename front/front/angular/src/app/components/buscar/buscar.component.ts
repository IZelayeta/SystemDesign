import { Component } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { finalize, map } from 'rxjs';
import { AgremiadoDTO } from '../../clases/agremiado-dto';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-buscar',
  templateUrl: './buscar.component.html',
  styleUrl: './buscar.component.css'
})
export class BuscarComponent {
  public isLoading = false;
  public src: string | undefined;
  public data$: any;
  public agremiado1!: Number;
  public agremiadoDTO!: AgremiadoDTO;

  constructor(private api: ApiService) {
  }

  search(value: any): any {
    console.log(value);
    this.isLoading = true;

    this.data$ = this.api.buscarAgremiado(value)
      .pipe(
        map((agremiado:AgremiadoDTO) => agremiado),
        finalize(() => this.isLoading = false)
      )
  }

  guardarAgremiado(envioForm:NgForm):void{
    if(envioForm.valid){
      console.log("Seleccion " + this.agremiado1);
    }
  }

  agremiar(){
    this.agremiadoDTO={
      "dni": this.agremiado1,
      "nombre":"",
      "apellido":"",
      "email":"",
      "telefono":"",
      "obrasSociales":[],
      "consultorios":[]
    };
    console.log("DNI: "+this.agremiadoDTO.dni);
    this.api.agremiar(this.agremiadoDTO, "").subscribe((a=>{
      console.log(a);
    }));

  }
  
}
