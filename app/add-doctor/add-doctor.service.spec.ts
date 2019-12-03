import { TestBed } from '@angular/core/testing';

import { AddDoctorService } from './add-doctor.service';

describe('AddDoctorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddDoctorService = TestBed.get(AddDoctorService);
    expect(service).toBeTruthy();
  });
});
