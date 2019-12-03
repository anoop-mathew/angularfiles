import { TestBed } from '@angular/core/testing';

import { ViewPatientService } from './view-patient.service';

describe('ViewPatientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewPatientService = TestBed.get(ViewPatientService);
    expect(service).toBeTruthy();
  });
});
