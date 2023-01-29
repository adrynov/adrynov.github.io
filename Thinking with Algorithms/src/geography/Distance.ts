// 

export type coords = { lat: number, lng: number };

/**
 * Calculates the shortest distance over the earth’s surface between two points.
 * 
 * The 'Haversine' formula is used for calculations: http://www.movable-type.co.uk/scripts/latlong.html
 * 
 * @param point1 First point
 * @param point2 Second point
 * 
 * @returns Distance in kilometers
 */
export const calculateDistanceHaversine = (point1: coords, point2: coords) => {
    const dLat = deg2rad(point2.lat - point1.lat);
    const dLon = deg2rad(point2.lng - point1.lng);
    const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(deg2rad(point1.lat)) * Math.cos(deg2rad(point2.lat)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c;
}

const R = 6371; // Earth radius

function deg2rad(deg: number) {
    return deg * (Math.PI / 180)
}