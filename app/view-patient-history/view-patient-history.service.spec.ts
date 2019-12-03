import { TestBed } from '@angular/core/testing';

import { ViewPatientHistoryService } from './view-patient-history.service';

describe('ViewPatientHistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewPatientHistoryService = TestBed.get(ViewPatientHistoryService);
    expect(service).toBeTruthy();
  });
});
