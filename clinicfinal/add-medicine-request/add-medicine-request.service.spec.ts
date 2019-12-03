import { TestBed } from '@angular/core/testing';

import { AddMedicineRequestService } from './add-medicine-request.service';

describe('AddMedicineRequestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddMedicineRequestService = TestBed.get(AddMedicineRequestService);
    expect(service).toBeTruthy();
  });
});
