def find_nth_word(N):
    lyrics = [
        "baby", "sukhwan", "tururu", "turu",
        "very", "cute", "tururu", "turu",
        "in", "bed", "tururu", "turu",
        "baby", "sukhwan"
    ]# 반복이 될 가사 내용

    song_length = len(lyrics)

    index = (N - 1) % song_length
    repeat_count = (N - 1) // song_length

    if lyrics[index].startswith("turu"):
        base_ru_count = lyrics[index].count("ru")
        total_ru_count = base_ru_count + repeat_count 

        if total_ru_count >= 5:
            return f"tu+ru*{total_ru_count}"
        else:
            return "tu" + "ru" * total_ru_count
    else:
        return lyrics[index]


N = int(input().strip())
print(find_nth_word(N))
