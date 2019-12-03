import { TestBed } from '@angular/core/testing';

import { AddStaffService } from './add-staff.service';

describe('AddStaffService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddStaffService = TestBed.get(AddStaffService);
    expect(service).toBeTruthy();
  });
});
