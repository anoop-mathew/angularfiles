import { TestBed } from '@angular/core/testing';

import { AddVendorService } from './add-vendor.service';

describe('AddVendorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddVendorService = TestBed.get(AddVendorService);
    expect(service).toBeTruthy();
  });
});
