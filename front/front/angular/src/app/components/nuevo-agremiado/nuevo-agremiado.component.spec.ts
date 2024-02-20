import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoAgremiadoComponent } from './nuevo-agremiado.component';

describe('NuevoAgremiadoComponent', () => {
  let component: NuevoAgremiadoComponent;
  let fixture: ComponentFixture<NuevoAgremiadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NuevoAgremiadoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NuevoAgremiadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
