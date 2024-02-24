import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, map, startWith } from 'rxjs';

@Component({
  selector: 'app-agregar-consultorio',
  templateUrl: './agregar-consultorio.component.html',
  styleUrl: './agregar-consultorio.component.css',
})
export class AgregarConsultorioComponent {
  myControl = new FormControl();
  options: string[] = ['Buenos Aires', 'Córdoba', 'Santa Fe', 'Mendoza', 'Chaco', 'Corrientes', 'Tucumán', 'Entre Ríos', 'Salta', 'Misiones', 'Formosa', 'San Juan', 'Jujuy', 'Río Negro', 'Neuquén', 'San Luis', 'Chubut', 'Catamarca', 'La Rioja', 'La Pampa', 'Santiago del Estero', 'Santa Cruz', 'Tierra del Fuego'];
  filteredOptions!: Observable<string[]>;

  ngOnInit() {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value))
    );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

}
