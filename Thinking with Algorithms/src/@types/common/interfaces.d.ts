// declare namespace common {
interface Person {
  firstName: string;
  lastName: string;
  age: number;
}

type GetFullName = (p: Person) => string;
// }
