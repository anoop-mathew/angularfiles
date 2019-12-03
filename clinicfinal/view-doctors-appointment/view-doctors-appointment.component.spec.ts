import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDoctorsAppointmentComponent } from './view-doctors-appointment.component';

describe('ViewDoctorsAppointmentComponent', () => {
  let component: ViewDoctorsAppointmentComponent;
  let fixture: ComponentFixture<ViewDoctorsAppointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDoctorsAppointmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDoctorsAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
