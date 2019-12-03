import { TestBed } from '@angular/core/testing';

import { ViewDoctorService } from './view-doctor.service';

describe('ViewDoctorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewDoctorService = TestBed.get(ViewDoctorService);
    expect(service).toBeTruthy();
  });
});
