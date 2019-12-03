import { TestBed } from '@angular/core/testing';

import { TodaysAppointmentService } from './todays-appointment.service';

describe('TodaysAppointmentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TodaysAppointmentService = TestBed.get(TodaysAppointmentService);
    expect(service).toBeTruthy();
  });
});
