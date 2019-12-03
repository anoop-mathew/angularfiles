import { TestBed } from '@angular/core/testing';

import { AddMedicineService } from './add-medicine.service';

describe('AddMedicineService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddMedicineService = TestBed.get(AddMedicineService);
    expect(service).toBeTruthy();
  });
});
