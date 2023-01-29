/**
 * Geography tests.
 *
 * @group geography
 */

import { calculateDistanceHaversine } from "./Distance";

describe('Distance ', () => {
  test(' is calculated using the Haverstine formula', () => {
      const distance = calculateDistanceHaversine({lat: 64.1265, lng: -21.8174}, {lat: 40.7128, lng: -74.0060});
      expect(distance).toBe(4208.198758424172)
  });
});
