# Dev persistence using type JSON

### Entity
- If you use MySQL the column type must be in this format
 <pre>
    @Type(type = "json")
    @Column(name="dataEvent", columnDefinition = "json")
    private Object object;
  </pre>

- If you use postgreSQL the column type must be in this format
 <pre>
    @Type(type = "jsonb")
    @Column(name="dataEvent", columnDefinition = "jsonb")
    private Object object;
  </pre>
