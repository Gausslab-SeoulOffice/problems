# LeetCode 68: Text Justification

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        i = 0
        line = []
        lines = []
        ans = []

        while i < len(words):
            line.append(words[i]) # 묶어줄 단어를 줄에 수집

            # 만약 i개 단어를 공백 포함 묶었더니 글자수가 초과하면
            if len(' '.join(line)) > maxWidth: 
                line.pop()                          # 글자수 초과의 원인이 된 맨 마지막 단어를 빼 버리고
                lines.append(line)                  # 그 줄을 최종 확정 
                line = []                           # 인덱스 갱신 없이 수집에 쓰인 줄을 초기화하고 다음 턴

            # 만약 i개 단어를 공백 포함 묶었더니 글자수가 딱 맞으면
            elif len(' '.join(line)) == maxWidth:
                lines.append(line)                  # 그 줄을 최종 확정
                line = []                           # 수집에 쓰인 줄을 최소화
                i += 1                              # 인덱스 갱신하고 다음 턴

            # 만약 i번째 단어가 맨 마지막 단어라면
            elif i == len(words) - 1:
                lines.append(line)                  # 그 줄을 최종 확정
                break                               # 순회 끝

            # 수집이 끝나지 않았다면, 계속 줄에 단어를 수집하기 위해 인덱스 갱신
            else:
                i += 1
                continue

        # 공백을 덧붙인 토큰을 리스트에 저장
        for line in lines:
            gaps = maxWidth - len(''.join(line))  # gaps: 글자를 제외하고 남는 사이띄개 개수
            n_gaps = len(line) - 1                # n_gaps: 공백의 개수

            if n_gaps > 0:                        # 공백 개수가 1 이상이면, 다음 변수들을 준비해 둔다
                sp_per_gap = gaps // n_gaps         # sp_per_gap: 공백 당 사이띄개 개수
                sp_left = gaps % n_gaps             # sp_left: 사이띄개 한 칸씩 보간해줘야 하는 공백의 개수

            for i in range(len(line)):
                if len(line) == 1:                  # 줄에 단어가 하나밖에 없다면
                    line[0] = f'{line[0]:<{maxWidth}}' # 오른쪽에 공백을 추가한다. line[i].ljust(maxWidth)) 도 가능
                    break

                elif len(line) > 1:                 # 줄에 단어가 2개 이상이면
                    if i == 0:                        # 맨 처음 단어에는 아무것도 하지 않고
                        continue
                    elif n_gaps >= 1:                 
                        line[i] = ' '*sp_per_gap + line[i] # 그 뒤의 단어에만 왼쪽에 공백을 sp_per_gap개만큼 덧댄다

            # sp_left개의 공백에 대해 여분 사이띄개를 하나씩 추가
            for i in range(1, len(line)):
                if sp_left > 0:
                    line[i] = ' ' + line[i]
                    sp_left -= 1

        # 전부 모아서 반환
        for l in lines:
            ans.append(''.join(l))
        
        return ans
