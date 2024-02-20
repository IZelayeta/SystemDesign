import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { AgremiadoDTO } from '../../clases/agremiado-dto';

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
