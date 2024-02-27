package com.rest.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rest.data.vo.v1.BookVO;
import com.rest.mapper.DozerMapper;
import com.rest.model.Book;
import com.rest.unittests.mapper.mocks.MockBook;

public class DozerConverterTest {
    
    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerMapper.parseObject(inputObject.mockEntity(), BookVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Book Name Test0", output.getName());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerMapper.parseListObject(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Book Name Test0", outputZero.getName());
        
        BookVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Book Name Test7", outputSeven.getName());
        
        BookVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Book Name Test12", outputTwelve.getName());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerMapper.parseObject(inputObject.mockVO(), Book.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Book Name Test0", output.getName());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerMapper.parseListObject(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Book Name Test0", outputZero.getName());
        
        Book outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Book Name Test7", outputSeven.getName());
        
        Book outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Book Name Test12", outputTwelve.getName());
    }
}
