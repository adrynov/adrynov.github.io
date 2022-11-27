package com.adrynov.benchmarking.models

internal interface VehicleService {
    val maxServiceIntervalInMonths: Int
    val maxDistanceBetweenServicesInKilometers: Int
        get() = 100000
}

internal abstract class Vehicle(val registrationNumber: String)


internal class Car(val numberOfSeats: Int, registrationNumber: String?) : Vehicle(registrationNumber!!),
    VehicleService {

    override val maxServiceIntervalInMonths: Int
        get() = 12
}


internal class Truck(val loadCapacity: Int, registrationNumber: String?) : Vehicle(registrationNumber!!),
    VehicleService {

    override val maxServiceIntervalInMonths: Int
        get() = 18
}

