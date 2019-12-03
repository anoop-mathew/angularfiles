import { TestBed } from '@angular/core/testing';

import { ViewDoctorsAppointmentService } from './view-doctors-appointment.service';

describe('ViewDoctorsAppointmentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewDoctorsAppointmentService = TestBed.get(ViewDoctorsAppointmentService);
    expect(service).toBeTruthy();
  });
});
