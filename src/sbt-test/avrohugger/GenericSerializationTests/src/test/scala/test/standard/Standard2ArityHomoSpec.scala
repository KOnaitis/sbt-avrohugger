import test._
import org.specs2.mutable.Specification
import com.sksamuel.avro4s.RecordFormat

class Standard2ArityHomoSpec extends Specification {
  skipAll
  "A case class with an `Int` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest14(1, 2)
      val record2 = AvroTypeProviderTest14(3, 4)
      val format = RecordFormat[AvroTypeProviderTest14]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Float` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest15(1F, 2F)
      val record2 = AvroTypeProviderTest15(3F, 4F)
      val format = RecordFormat[AvroTypeProviderTest15]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Long` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest16(1L, 2L)
      val record2 = AvroTypeProviderTest16(3L, 4L)
      val format = RecordFormat[AvroTypeProviderTest16]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Double` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest17(1D, 2D)
      val record2 = AvroTypeProviderTest17(3D, 4D)
      val format = RecordFormat[AvroTypeProviderTest17]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Boolean` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest18(true, false)
      val record2 = AvroTypeProviderTest18(false, true)
      val format = RecordFormat[AvroTypeProviderTest18]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `String` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest19("1", "2")
      val record2 = AvroTypeProviderTest19("1", "2")
      val format = RecordFormat[AvroTypeProviderTest19]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }
/*
Avro4s is used to convert to `GenericRecord` for testing, chokes on `null`

  "A case class with an `Null` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest20(null, null)
      val record2 = AvroTypeProviderTest20(null, null)
      val format = RecordFormat[AvroTypeProviderTest20]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }
*/
  "A case class with an `List[String]` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest24(List("mekka.lekka.hi"), List("mekka.hiney.ho"))
      val record2 = AvroTypeProviderTest24(List("time"), List("travel"))
      val format = RecordFormat[AvroTypeProviderTest24]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `List[Int]` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest25(List(1, 2), List(3,4))
      val record2 = AvroTypeProviderTest25(List(5, 6), List(7,8))
      val format = RecordFormat[AvroTypeProviderTest25]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Option[String]` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest26(Some("sun"), Some("moon"))
      val record2 = AvroTypeProviderTest26(Some("day"), Some("night"))
      val format = RecordFormat[AvroTypeProviderTest26]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Option[Int]` field in the second position" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTest27(Some(1), Some(2))
      val record2 = AvroTypeProviderTest27(Some(3), Some(4))
      val format = RecordFormat[AvroTypeProviderTest27]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }
/*
Avro4s is used to convert to `GenericRecord` for testing, chokes on `Map`

  "A case class with two Map[Int, Int] fields" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTestMap04(Map("Gorgonzola"->2), Map("Cheddar"->4))
      val record2 = AvroTypeProviderTestMap04(Map("Gouda"->5), Map("Swiss"->6))
      val format = RecordFormat[AvroTypeProviderTestMap04]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with two Map[Int, String] fields" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTestMap05(Map("Havana"->"Cuba"), Map("World"->"series"))
      val record2 = AvroTypeProviderTestMap05(Map("Bogota"->"Colombia"), Map("time"->"series"))
      val format = RecordFormat[AvroTypeProviderTestMap05]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with two Map[String, Option[List[Int]]] fields" should {
    "serialize and deserialize correctly" in {
      val record1 = AvroTypeProviderTestMap06(Map("Olala"->Some(List(1,4))), Map("Rumpole"->None))
      val record2 = AvroTypeProviderTestMap06(Map("Cran"->Some(List(3,5))), Map("Doc"->None))
      val format = RecordFormat[AvroTypeProviderTestMap06]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }
  */
}
