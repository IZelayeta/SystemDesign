import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { AgremiadoDTO } from '../../clases/agremiado-dto';
import { NgForm } from '@angular/forms';
import { finalize, map } from 'rxjs';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent implements OnInit {
  [x: string]: any;
  codigo!: any;
  public archivos: any = []
  cantCuotas:number=12-new Date().getMonth();
  agremiadoDTO!: AgremiadoDTO;

  constructor(private api:ApiService){}

  ngOnInit(): void {
    console.log("CantCuotas: "+this.cantCuotas);
    this.ultimoCodigo();
  }

  fecha: Date = new Date();

  capturarFile(event: any): any {
    const archivoCapturado = event.target.files[0]
    this.archivos.push(archivoCapturado)
    //console.log(event.target.files);
  }

  ultimoCodigo(){
      this.api.ultimoCodigo().subscribe((a=>{
      console.log(a);
      this.codigo=a;}))
  }


/*BUSCAR*/
  public isLoading = false;
  public src: string | undefined;
  public data$: any;
  public agremiado1!: Number;

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


  /*extraerBase64 = async ($event: any ) => new Promise((resolve) => {
    try {
      const unsafeImg = window.URL.createObjectURL($event);
      const image = this['santizer'].bypassSecurityTrustUrl(unsafeImg);
      const reader = new FileReader();
      reader.readAsDataURL($event);
      reader.onload = () => {
        resolve({
          blob:$event,image,
          base: reader.result
        });
        reader.onerror = error => {
          resolve({
            blob: $event,
            image,
            base: null
          });
        };
      }
      
    }
    catch (e) {
      return null;
    }
  })*/
}
