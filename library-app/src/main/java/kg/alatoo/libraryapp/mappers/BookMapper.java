package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    //TODO: HW add publisher and authors to BookDTO and make mapper to convert that props too
    //     pay attention publisher should be PublisherDTO and authors like List<AuthorDTO>

    BookDTO bookToBookDto(Book book);

    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "authors", ignore = true)
    Book bookDtoToBook(BookDTO dto);
}
