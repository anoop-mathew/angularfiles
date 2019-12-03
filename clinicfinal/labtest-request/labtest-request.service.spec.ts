import { TestBed } from '@angular/core/testing';

import { LabtestRequestService } from './labtest-request.service';

describe('LabtestRequestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LabtestRequestService = TestBed.get(LabtestRequestService);
    expect(service).toBeTruthy();
  });
});
