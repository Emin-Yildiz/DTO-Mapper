# DTO(Data Transfer Object) & Mapper

- Dto uygulama katmanları arasında veriyi transfer etmek için kullanılır. Genel olarak database den gelen veriyi source olarak kullanır.

- Bir katmanda elimizde var olan data diğer katmanda kullanılacak ise, veriyi tasımak diğer katmanda yeniden çağrım yapmamak için anlamlı bir çözümdür. Ve Dto'lar nerdeyse hiç davranış içermezler. Veriyi olduğu gibi ileten objelerdir.

- DTO’lar, bir katmandan diğerine veri aktarımını kolaylaştırır ve bu sayede uygulamanın performansını arttırır.

- DTO’lar, bir katmandan diğerine veri aktarımını kolaylaştırdığı için genellikle servislerde kullanılır.

- DTO’lar, Model Mapper gibi kütüphanelerle birlikte kullanılır ve bu sayede Entity nesnelerini database’den çektiğimiz haliyle değil, bu nesneleri istediğimiz formata çevirmemizi sağlar.

![DTO](img/img.svg)

## Mapper

- Mapper, genel olarak bir nesnenin haritalanmasını veya eşleştirmesini yapan bir aracı ifade eder. Farklı alanlar veya yapılar arasında veri transferi veya dönüşümü gerçekleştirmek için kullanılan araçlardır.

- Bu araçlar, kaynak ve hedef arasındaki veri yapısının veya nesnenin eşleştirmesini gerçekleştirir ve veri aktarımını kolaylaştırır.

## Model Mapper Kullanımı

- Model Mapper'ın projeye dahil edilmesi.

```xml
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.0.0</version>
</dependency>
```

### Model Mapper Eşleştirme Stratejisi

Model Mapper kütüphanesinde eşleştirme stratejileri 4'e ayrılır.

1. **STANDART STRATEJİLER**:
    Bu kategoride, varsayılan eşleştirme stratejileri bulunur. Bu stratejiler, genel olarak kaynak ve hedef alanların isimlendirme ve veri türleri açısından eşleşmesini sağlar. Örnek olarak MatchingStrategies.STANDARD verilebilir.
2. **LOOSE STRATEJİLER**:
    Bu kategori, eşleştirme işleminde daha esnek bir yaklaşım sağlar. İsimlendirme farklılıklarına veya bazı kısıtlamalara izin verir. Örnek olarak MatchingStrategies.LOOSE verilebilir.
3. **CASE SENSITIVE STRATEJİLERİ**:
    Bu kategori, eşleştirme işleminde büyük/küçük harf duyarlılığına odaklanır. Bazı stratejiler tam eşleşme yaparken büyük/küçük harf duyarlılığını dikkate alırken, diğerleri duyarlı olmadan eşleştirme yapar.
4. **CUSTOM STRATEJİLER**
     Bu kategori, kullanıcı tarafından özelleştirilebilen ve ihtiyaca göre ayarlanabilen eşleştirme stratejilerini içerir. ModelMapper, kullanıcının kendi stratejilerini oluşturabilmesine olanak tanır.

```java
ModelMapper modelMapper = new ModelMapper();
modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
```

Basit bir map işlemi yapacak olursak.

```java
School school = mapper.map(createSchool, School.class);
```

Yukarıdaki kod satırı, createSchool nesnesini School sınıfına dönüştürerek school değişkenine atar. Bu dönüşüm, ModelMapper tarafından otomatik olarak gerçekleştirilir. Kaynak nesneyle hedef sınıfın alanları arasındaki eşleştirme kurallarına ve ModelMapper'ın yapılandırmasına bağlı olarak uygun değerler atanır.

## Map Struct Kullanılımı

- Map struct projeye dahil edilmesi

```xml
<dependency>
   <groupId>org.mapstruct</groupId>
   <artifactId>mapstruct</artifactId>
   <version>1.5.1.Final</version>
</dependency>
```

- Aynı zamanda pom.xml dosyamızın build bölümüne aşağıdaki plugin'i eklemeliyiz.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version> 
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.5.1.Final</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

- Aşağıdaki kod satırı, studentMapper adlı bir MapStruct mapper'ı kullanarak student adlı bir nesneyi StudentDTO sınıfına dönüştürmek için kullanılır.

```java
StudentDTO studentDto = studentMapper.map(student);
```

## Map Struct vs Model Mapper

- MapStruct, ModelMapper'a göre daha hızlıdır. Çünkü MapStruct, kod derlenirken kodu optimize eder ve kodun çalışma zamanında daha hızlı çalışmasını sağlar.
- MapStruct, ModelMapper'a göre daha az işlemci gücü kullanır. Çünkü MapStruct, kod derlenirken kodu optimize eder ve kodun çalışma zamanında daha az işlemci gücü kullanmasını sağlar.
- MapStruct: Derleme zamanında üretilen optimize koduyla MapStruct, genellikle daha yüksek performans sunar. Bu nedenle, büyük ölçekli projelerde daha tercih edilebilir olabilir.
- ModelMapper: ModelMapper, çalışma zamanında kod ürettiği için bazı performans kayıplarına neden olabilir. Performans gereksinimleri yüksek projelerde bu durum göz önünde bulundurulmalıdır.
