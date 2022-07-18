enum Grade:
  case Bad, Mediocre, Inadequate, Passable, Good, VeryGood, Excellent
  def median(grades: Seq[Grade]): Grade =
    val sorted = grades.sortBy(grade => grade.ordinal)
    sorted.apply((grades.size)/2)





case class Candidate(name: String)
case class Ballot(grades: Map[Candidate, Grade])
val tiramisu    = Candidate("Tiramisu")
val cremeBrulee = Candidate("Crème brûlée")
val cheesecake  = Candidate("Cheesecake")

val ballot1 = Ballot(
  Map(
    tiramisu    -> Grade.Excellent,
    cremeBrulee -> Grade.Good,
    cheesecake  -> Grade.Inadequate
  )
)

val ballot2 = Ballot(
  Map(
    tiramisu    -> Grade.Excellent,
    cremeBrulee -> Grade.Passable,
    cheesecake  -> Grade.Good
  )
)

val ballot3 = Ballot(
  Map(
    tiramisu    -> Grade.VeryGood,
    cremeBrulee -> Grade.Inadequate,
    cheesecake  -> Grade.Good
  )
)

val ballots: Seq[Ballot] = Seq(ballot1,ballot2,ballot3)
val allGrades: Seq[(Candidate, Grade)] =
  ballots.flatMap(ballot => ballot.grades)

val gradesPerCandidate: Map[Candidate, Seq[Grade]] =
  allGrades.groupMap((candidate,grade) => candidate)((candidate,grade) => grade)

gradesPerCandidate

gradesPerCandidate.values
