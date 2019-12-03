import { TestBed } from '@angular/core/testing';

import { ViewMedicineService } from './view-medicine.service';

describe('ViewMedicineService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewMedicineService = TestBed.get(ViewMedicineService);
    expect(service).toBeTruthy();
  });
});
